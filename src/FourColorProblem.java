/**
 * 
 * @author Stuart Spiegel
 * Date: 12/5/2018
 *
 */
public class FourColorProblem {

	private static final int[] color = { 1, 2, 3, 4 };
	// color array, represents four colors

	private static int[][] map = { { 0, 1, 1, 0, 1, 1, 0 }, { 1, 0, 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1, 1, 0 },
			{ 0, 1, 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0, 1, 0 } };
	// adjacency matrix representing the graph

	private static int[] countryColor = new int[7];
	// this is the array that holds the color values for each country

	public static void main(String[] args) {
		
		int count = 0; //counter for recursive calls
		
		for(int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				colorMap(map[i][j]);  //call the main function
				count++;
				System.out.println(count);

			}
		}

	}

	/**
	 * 
	 * @param the
	 *            current country to be checked
	 * @return after searching the adjacency matrix with recursive calls, this
	 *         function returns true when a solution is found for the given map
	 * 
	 */
	private static boolean colorMap(int country) {
		
		System.out.println("Checking Country " + country);
		boolean check;
		for (int j = 0; j < countryColor.length; j++) {
			if (useColor(country, color[j]) == true) {
				countryColor[country] = color[j];
			}
			else
				continue; // mark: try and color the country with a different color
			if (country == countryColor.length - 1)
				return true;
			check = colorMap(country + 1);
			System.out.println(check);
			if (check == true)
				return true;
			countryColor[country] = 0;
		}
		return false;
	}

	/**
	 * 
	 * @param the
	 *            country to be colored
	 * @param the
	 *            color to use when coloring the passed country
	 * @return (true/false) whether is safe to color "the country" that passed color
	 * 
	 */
	private static boolean useColor(int country, int color) {
		for (int i = 0; i < map.length; i++) {
			if (map[country][i] == 1 && countryColor[i] == color) {
				System.out.println("The Country:  " + country + " cant be " + color);
				return false;
			}
		}
		return true;
	}

}
