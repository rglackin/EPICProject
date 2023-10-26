package project;

public class Timer {
	
	public void startTimer() { //method to begin timer
		long startTime = System.currentTimeMillis();
	}
	
	public double end() { //method to end timer and return elapsed time
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return elapsedTime / 1000.0;
	}
	/* In main method:
	*  Timer quizTimer = new Timer();
	*  quizTimer.start();
	*  double elapsedTime = quizTimer.end();
	*/
}