
public class GraphAdjMatrix implements Graph {
	int[][]edges;
	int size;
	public GraphAdjMatrix(int size) {
		edges = new int[size][size];
		this.size = size;
	}


	@Override
	public void addEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;

	}

	@Override
	public int getEdge(int v1, int v2) {
		if(edges.length==0) {
			return 0;
		}
		return edges[v1][v2];
		
	}
	
	int minKey(int key[], Boolean mstSet[])
    {
        
        int min = Integer.MAX_VALUE;
        int min_index=-1;
 
        for (int v = 0; v < size; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }


	
	
	
	
	
	
	

	@Override
	public int createSpanningTree() {
		int parent[] = new int[size];
        int key[] = new int [size];
        Boolean mstSet[] = new Boolean[size];
		
        for (int i = 0; i < size; i++)
        {
            key[i] = -1;
            mstSet[i] = false;
        }
        
        
        key[0] = 0;     
        parent[0] = -1; 
        
        for (int count = 0; count < size-1; count++)
        {
            
            int u = minKey(key, mstSet);
 
            
            mstSet[u] = true;
 
            
            for (int v = 0; v < size; v++)
 
               
                if (edges[u][v]!=0 && mstSet[v] == false &&
                    edges[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = edges[u][v];
                }
        }
        
        int ans =0;
       for (int i = 1; i < size; i++) {
    	   ans = ans + edges[i][parent[i]];
    }
 
        
        
        
        
        return ans;
	}

}
