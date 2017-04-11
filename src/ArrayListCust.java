


public class ArrayListCust{
	static int size;
	static int actualSize;
	static int maxSize;
	static Object[] values;
	
	ArrayListCust(int size){
		values = new Object[size];
		actualSize=0;
	}
	
	static void insert(Object val){
		values[actualSize++] = val;
		doubletheSize(actualSize);
	}
	
	static private void doubletheSize(int actualSize){
		float percentageOfFill = (actualSize/size);
		if(percentageOfFill>=0.7){
		 size = size*2;
		 Object[] newValues = new Object[size];
		 for(int i=0;i<values.length;i++){
			newValues[i] = values[i];
		 }
		 values = newValues;
		}
		
	}
	
	static void removeAtPos(int pos){
		for(int i=0;i<values.length;i++){
			if(pos==i && (i+1)<values.length){
				values[i]=values[i+1];
			}
		}
	}
	
	static Object getAtPos(int pos){
		for(int i=0;i<values.length;i++){
			if(pos==i){
				return values[pos];
			}
		}
		return -1;
	}
	
	static void print(){
		for(int i=0;i<values.length;i++){
		 System.out.print(values[i]+" ");
		}
	}
	
	public static void main(String[] args){
		int size = 4;
		ArrayListCust arr = new ArrayListCust(size);
		arr.insert(2);
		arr.insert(5);
		arr.insert(8);
		System.out.println("Actual Size="+arr.size+" "+" New Size="+size);
		arr.print();
		System.out.println(arr.getAtPos(1));
		arr.removeAtPos(1);
		arr.print();
		
	}

}

