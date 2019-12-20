//Lab 6
//File name:LQHashed_Tsui
//Name: Wei-Hsuan Tsui
//Course:COSC2436

public class LQHashed_Tsui {
	int N;
	int n=0;
	int defaultQuotient = 9967;
	double loadingFactor = 0.75;
	Student_Tsui deleted;
	public Student_Tsui[] data;
	
	
	public LQHashed_Tsui (int length) {
		int pct=(int)((1.0/loadingFactor -1)*100.0);
		N=fourKPlus3(length,pct);
		data= new Student_Tsui[N];
		deleted =new Student_Tsui ();
		for (int i=0;i<N;i++)
			data[i]=null;
	}
	public boolean insert(Student_Tsui newStudent) {
        boolean noError;
        boolean hit = false;
        int pass, q, offset, ip;
        int pk = stringToInt(newStudent.getKey());
        if((((double) n) / N) < loadingFactor){
            pass = 0;
            q = pk / N;
            offset = q;
            ip = pk % N;
            if(q % N ==0)
                offset = defaultQuotient;
            while (pass < N){
                if(data[ip] == null || data[ip] == deleted){
                    hit = true;
                    break;
                }
                ip = (ip + offset) % N;
                pass++;
            }if (hit == true){
                data[ip] = newStudent.deepCopy();
                n++;
                return noError = true;          
            }else
                return noError = false;

        }else
            return noError = false;
	}
	public Student_Tsui fetch(String targetKey){ 
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt(targetKey); // preprocess the key
		pass = 0;
		q = pk / N;
		offset = q ;
		ip = pk % N;
		if(q%N == 0)
			offset = defaultQuotient;
		while(pass < N)
		{ 	if(data[ip] == null|| data[ip] == deleted) //node not in structure
				break;
			if(data[ip].compareTo(targetKey) == 0) //node found
			{ 	hit = true;
				break;
			}
			ip = (ip + offset)%N; //collision occurred
			pass = pass +1;
		}
		if(hit == true) //return a deep copy of the node
			return data[ip].deepCopy();
		else 	
			return null;
			
	}//end of the Fetch method
	public boolean delete(String targetKey)
	{ boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt(targetKey); // preprocess the key
		pass = 0;
		q = pk / N;
		offset = q;
		ip = pk % N;
		if(q%N == 0)
			offset = defaultQuotient;
		while(pass < N)
		{ 	if(data[ip] == null) //node not in structure
				break;
			if(data[ip].compareTo(targetKey) == 0) // node found
			{ hit = true;
				break;
			}
			ip = (ip + offset)%N; //collision occurred
			pass = pass +1;
		}
		if(hit == true) //delete the node
		{ data[ip] = deleted;
			n--;
			return noError = true;
		}
		else
			return noError = false;
	}//end of the Delete method
	public boolean update(String targetKey, Student_Tsui newStudent_Tsui)
	{ 	if(delete(targetKey) == false)
			return false;
		else if(insert(newStudent_Tsui) == false)
			return false;
		return true;
	}//end of the Update method
	public void showAll()
	{ 	for(int i= 0; i<N; i++)
			if(data[i] != null && data[i] != deleted)
				System.out.println(data[i]);
	}
	public static int fourKPlus3(int n, int pct) // from Figure 5.16
	{ 	boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		double pctd = pct;
		prime = (int)(n * (1.0 + (pctd/100.0))); // guess the prime pct percent larger than n
		
		if(prime%2 == 0) //if even make the prime guess odd
			prime = prime +1;
		while(fkp3 == false) // not a 4k+3 prime
		{ 	while(aPrime == false) // not a prime
			{	 highDivisor = (int)(Math.sqrt(prime) + 0.5);
			for(d = highDivisor; d > 1; d--)
			{ 	if(prime%d == 0)
					break;
			}
			if(d != 1) // prime not found
				prime = prime +2;
			else
				aPrime = true;
			}// end of the prime search loop
			if((prime-3)%4 == 0)
				fkp3 = true;
			else
			{ 	prime = prime +2;
				aPrime = false;
			}
		}// end of 4k+3 prime search loop
	return prime;	
	}
	public static int stringToInt(String aKey) // from Figure 5.18
	{ 	int pseudoKey = 0;
		int n = 1;
		int cn= 0;
		char c[] = aKey.toCharArray();
		int grouping =0;
		while (cn < aKey.length()) // there is still more character in the key
		{ 	grouping = grouping << 8; // pack next four characters in i
			grouping = grouping + c[cn];
			cn = cn + 1;
			if (n==4 || cn == aKey.length()) // 4 characters are processedor no more characters
			{ 	pseudoKey = pseudoKey + grouping;
				n = 0;
				grouping = 0;
			}
			n = n + 1;
		}
		return Math.abs(pseudoKey);
		}
	}