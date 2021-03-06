

public class Knight{
	private int[][] board;
	private boolean solved = false, closed = false;
	private int rank = 0,size;
	private int blah;

	public Knight(int size){
		board = new int[size][size];
		this.size = size;
	}

//	public void solve()

	public void solve(){
		solve(false);
	}

	public void solve(boolean closed){
		this.closed = !closed;
		tour(0,0,0);
	}

	public boolean tour(int px,int py,int rank){
		try{
			if(!solved || !closed){
				if(board[px][py]==0){
					board[px][py]=++rank;
					if(rank==size*size){
						solved=true;
						if(solved && board[px][py]==1){
							closed = true;
						}
					}
				}
				else{
					return false;
				}
				
				if(tour(px+2,py+1,rank)){}
				else if(tour(px+2,py-1,rank)){}
				else if(tour(px+1,py-2,rank)){}
				else if(tour(px+1,py+2,rank)){}
				else if(tour(px-2,py+1,rank)){}
				else if(tour(px-2,py-1,rank)){}
				else if(tour(px-1,py+2,rank)){}
				else if(tour(px-1,py-2,rank)){}
				else{
					board[px][py]=0;
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;

	}


	public String toString(){
		String total = "";
		for(int x=0;x<size;x++){
			for(int y=0;y<size;y++){
				total+= board[x][y];
				total+= "\t";
			}
			total+= "\n";
		}
		return total;
	}



}