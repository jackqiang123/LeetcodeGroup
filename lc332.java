// Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
// Note:
// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.
// Example 1:
// tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
// Example 2:
// tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
// Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
//
public class Solution {
		   class City{
		     String name;
		     boolean visit;
		     public City(String name){
		       this.name = name; visit = false;
		     }
		   }
		       List<String> res;
		       Map<String, List<City>> map;
		     public List<String> findItinerary(String[][] tickets) {
		       map = new HashMap();
		       res = new ArrayList();
		       for (int i = 0; i < tickets.length; i++){
		         String from = tickets[i][0];
		         String to = tickets[i][1];
		         if (map.get(from) == null) map.put(from, new ArrayList<City>());
		           map.get(from).add(new City(to));
		       }
		       List<String> cur = new ArrayList<String>();
		       cur.add("JFK");
		       dfs(cur, tickets.length + 1);
		       return res;
		     }

		     private void dfs(List<String> cur, int count){
		       if (res.size() != 0)
		    	   return;
		       else if (cur.size() == count){
		         res.addAll(cur);
		       }
		       else {
		         String curCity = cur.get(cur.size()-1);
		         List<City> nextHop = map.get(curCity);
		         if (nextHop == null) return;
		         Collections.sort(nextHop, new Comparator<City>(){
		           public int compare(City c1, City c2){
		             return c1.name.compareTo(c2.name);
		           }
		         });
		         int size = nextHop.size();
		         for (int i = 0; i < size; i++){
		             City next = nextHop.get(i);
		           if (next.visit) continue;
		           if (i == 0 || !nextHop.get(i-1).name.equals(nextHop.get(i).name) || nextHop.get(i).visit){
		             next.visit = true;
		             cur.add(next.name);
		             dfs(cur, count);
		             cur.remove(cur.size()-1);
		             next.visit = false;
		           }
		         }
		       }
		     }
		   }
