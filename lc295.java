// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
// Examples:
//
// [2,3,4] , the median is 3
//
// [2,3], the median is (2 + 3) / 2 = 2.5
//
// Design a data structure that supports the following two operations:
//
//     void addNum(int num) - Add a integer number from the data stream to the data structure.
//     double findMedian() - Return the median of all elements so far.
//
// For example:
//
// add(1)
// add(2)
// findMedian() -> 1.5
// add(3)
// findMedian() -> 2

class MedianFinder {
    PriorityQueue<Integer> leftPart = new PriorityQueue<>(10, Collections.reverseOrder()); //max heap
    PriorityQueue<Integer> rightPart = new PriorityQueue<>(); // min heap
    // Adds a number into the data structure.
    public void addNum(int num) {
      if (leftPart.isEmpty()){
        leftPart.add(num);
      }
      else if (rightPart.isEmpty() || num < rightPart.peek()){
          leftPart.add(num);
          if (leftPart.size() >= rightPart.size() + 2)
            rightPart.add(leftPart.remove());
      }
      else{
        rightPart.add(num);
        if (rightPart.size() > leftPart.size()){
          leftPart.add(rightPart.remove());
        }
      }
    }

    // Returns the median of current data stream
    public double findMedian() {
      int leftCount = leftPart.size();
      int rightCount = rightPart.size();
      if (rightCount == 0) return leftPart.peek();
      else if (leftCount == 0) return rightPart.peek();
      if (leftCount == rightCount){
        return (leftPart.peek() + rightPart.peek())/2.0;
      }
      else{
        return leftPart.peek()*1.0;
      }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
