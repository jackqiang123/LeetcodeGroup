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
				 List<String> res;
		     public List<String> findItinerary(String[][] tickets) {
					 res = new ArrayList<String>();
					 Map<String, PriorityQueue<String>> map = new HashMap();
					 for (String[] ticket : tickets){
						 if (map.get(ticket[0]) == null) map.put(ticket[0], new PriorityQueue<String>());
						 map.get(ticket[0]).add(ticket[1]);
					 }
					 dfs(map, "JFK");
					 return res;
		     }
				 private void dfs(Map<String, PriorityQueue<String>> map, String curCity){
					 PriorityQueue<String> nextHop = map.get(curCity);
					 if (nextHop == null) {
					     res.add(0, curCity); return;
					 }
					 while(!nextHop.isEmpty()){
						 String nextCity = nextHop.remove();
						 dfs(map, nextCity);
					 }
					 res.add(0, curCity);
				 }
	}
