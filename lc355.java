// Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
//
//     postTweet(userId, tweetId): Compose a new tweet.
//     getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
//     follow(followerId, followeeId): Follower follows a followee.
//     unfollow(followerId, followeeId): Follower unfollows a followee.
//
// Example:
//
// Twitter twitter = new Twitter();
//
// // User 1 posts a new tweet (id = 5).
// twitter.postTweet(1, 5);
//
// // User 1's news feed should return a list with 1 tweet id -> [5].
// twitter.getNewsFeed(1);
//
// // User 1 follows user 2.
// twitter.follow(1, 2);
//
// // User 2 posts a new tweet (id = 6).
// twitter.postTweet(2, 6);
//
// // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
// twitter.getNewsFeed(1);
//
// // User 1 unfollows user 2.
// twitter.unfollow(1, 2);
//
// // User 1's news feed should return a list with 1 tweet id -> [5],
// // since user 1 is no longer following user 2.
// twitter.getNewsFeed(1);
public class Twitter {
    Map<Integer, Set<Integer>> user;
    Map<Integer, List<Message>> message;
    long timeStamp;
    class Message{
      int id;
      long time;
      public Message(int id, long t){this.id = id; this.time = t;}
    }
    /** Initialize your data structure here. */
    public Twitter() {
      user = new HashMap();
      message = new HashMap();
      timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
      if (message.get(userId) == null) message.put(userId, new ArrayList<Message>());
      message.get(userId).add(0, new Message(tweetId,timeStamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
      List<Integer> res = new ArrayList<Integer>();
      PriorityQueue<Message> pq = new PriorityQueue(10, new Comparator<Message>(){
        public int compare(Message m1, Message m2){
          return Long.compare(m1.time, m2.time);
        }
      });
      if (message.get(userId) != null){
        for (int i = 0; i < Math.min(10, message.get(userId).size()); i++){
          if (pq.size() < 10) pq.add(message.get(userId).get(i)); // since we add new message at the head
        }
      }
      Set<Integer> nb = user.get(userId);
      if (nb != null){
      for (int fol : nb){
        if (message.get(fol) == null) continue;
        for (int i = 0; i < Math.min(10, message.get(fol).size()); i++){
          if (pq.size() < 10) pq.add(message.get(fol).get(i));
          else {
            if (pq.peek().time < message.get(fol).get(i).time){
              pq.remove();
              pq.add(message.get(fol).get(i));
            }
            else break;
          }
        }
      }
      }
      while(!pq.isEmpty())
        res.add(0, pq.remove().id);
      return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
      if (followerId == followeeId) return; //cannot follow self
      if (user.get(followerId) == null) user.put(followerId, new HashSet<Integer>());
      user.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
      if (user.get(followerId) == null) return;
      user.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
