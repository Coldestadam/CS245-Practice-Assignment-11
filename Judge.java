public class Judge{
	public int findJudge(int N, int[][] trust){
		Graph graph = new Graph(N);

		for(int row=0; row<trust.length; row++){
			//I have to subtract 1 so the person with 1 can be in index 0
			int person_trusting = trust[row][0] - 1;
			int person_who_is_bring_trusted = trust[row][1] - 1;

			graph.addEdge(person_trusting, person_who_is_bring_trusted);
		}


		int[][] adjacency_matrix = graph.getAdjacencyMatix();
		for(int row=0; row<adjacency_matrix.length; row++){
			if(isRowEmpty(adjacency_matrix[row])){
				return row + 1;
			}
		}

		return -1;
	}
	
	public boolean isRowEmpty(int[] row){
		boolean empty = true;
		for(int i=0; i<row.length; i++){
			if(row[i] == 1)
				empty = false;
		}

		return empty;
	}

	public static void main(String[] args) {
		Judge judge = new Judge();
		int[][] example_5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4,3}};
		int answer5 = judge.findJudge(4, example_5);

		int[][] example_3 = {{1, 3}, {2, 3}, {3,1}};
		int answer3 = judge.findJudge(3, example_3);

		System.out.println("This is the answer for example 5 in the pdf: " 
			+ answer5);
		System.out.println("This is the answer for example 3 in the pdf: " 
			+ answer3);
	}

}