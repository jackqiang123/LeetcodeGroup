// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
// For example,
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3
public class MovingAverage {
    int max;
    int sumWin;
    Deque data;
    public MovingAverage(int size) {
      this.max = size;
      this.data = new LinkedList();
      this.sumWin = 0;
    }

    public double next(int val) {
      if (data.size() < max){
        deque.addLast(val);
        sumWin += val;
      }
      else{
        int last = deque.removeFirst();
        deque.addLast(val);
        sumWin = sumWin + val - last;
      }
      return sumWin*1.0/data.size();
    }
  }
