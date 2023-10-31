import java.lang.Math;
public class userStatistics {
	
	public static double median(int[] results) { // Return median from array of quiz results
		double median = 0;
		int[] sortedResults = bubbleSort(results); // Sort results in order
		if ((sortedResults.length % 2) == 1) {	//Find middle index for odd number length array
			median = sortedResults[sortedResults.length / 2];
		} else {	//Find middle index for even number length array
			median = (sortedResults[sortedResults.length / 2] + sortedResults[(sortedResults.length / 2) -1]) / 2;
		} 
		return median;

	}

	public static double mean(int[] results) {	// Return mean from array of quiz results
		int sum = 0;
		int mean = 0;
		for (int i = 0; i < results.length; i++) {
			sum += results[i];
		}
		mean = sum / results.length;
		return mean;
	}

	public static double standardDeviation(int[] results) {	// Return standard deviation from array of quiz results
		double mean = mean(results);
		double sumOfSquares = 0;
		for (int i = 0; i < results.length; i++) {
			sumOfSquares += Math.pow((results[i] - mean), 2);
		}
		return (Math.sqrt((sumOfSquares / results.length)));
	}

	private static int[] bubbleSort(int[] arr) { // method to sort array of integers using bubblesort, used to calculate mean.
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < arr.length - 1; i++) {
			swapped = false;
			for (j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			if (swapped == false)
				break;
		}
		return arr;
	}
}