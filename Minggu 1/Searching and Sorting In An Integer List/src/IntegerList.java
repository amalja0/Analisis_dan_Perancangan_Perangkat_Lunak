// **************************************************************** 
// IntegerList.java 
// 
// Define an IntegerList class with methods to create, fill, 
// sort, and search in a list of integers. 
// 
// **************************************************************** 

import java.util.Scanner; 

public class IntegerList 
{ 
    int[] list; //values in the list 
    
    //------------------------------------------------------- 
    //create a list of the given size 
    //------------------------------------------------------- 
    public IntegerList(int size) 
    { 
        list = new int[size]; 
    } 
    
    //------------------------------------------------------- 
    //fill array with integers between 1 and 100, inclusive 
    //------------------------------------------------------- 
    public void randomize() 
    { 
        for (int i=0; i<list.length; i++) 
            list[i] = (int)(Math.random() * 100) + 1; 
    } 
    
    //------------------------------------------------------- 
    //print array elements with indices 
    //------------------------------------------------------- 
    public void print() 
    { 
        for (int i=0; i<list.length; i++) 
            System.out.println(i + ":\t" + list[i]); 
    } 
    
    //------------------------------------------------------- 
    //return the index of the first occurrence of target in the list. 
    //return -1 if target does not appear in the list 
    //------------------------------------------------------- 
    public int search(int target) 
    { 
        int location = -1; 
            for (int i=0; i<list.length && location == -1; i++) 
                if (list[i] == target) 
                    location = i; 
        return location; 
    } 
    
    //------------------------------------------------------- 
    //sort the list into ascending order using the selection sort algorithm 
    //------------------------------------------------------- 
    public void selectionSortIncrease() 
    { 
        int minIndex; 
        for (int i=0; i < list.length-1; i++) 
        { 
            //find smallest element in list starting at location i 
            minIndex = i; 
            for (int j = i+1; j < list.length; j++) 
                if (list[j] < list[minIndex]) 
                    minIndex = j; 
            //swap list[i] with smallest element 
            int temp = list[i]; 
            list[i] = list[minIndex]; 
            list[minIndex] = temp; 
        } 
    } 

    public void selectionSortDecrease() 
    { 
        int maxIndex; 
        for (int i=0; i < list.length-1; i++) 
        { 
            maxIndex = i; 
            for (int j = i+1; j < list.length; j++) 
                if (list[j] > list[maxIndex]) 
                    maxIndex = j; 
            
            int temp = list[i]; 
            list[i] = list[maxIndex]; 
            list[maxIndex] = temp; 
        } 
    } 

    public void replaceFirst(int oldVal, int newVal) {
        int position = search(oldVal);

        if(position == -1) {
            throw new java.lang.Error("Value not found!");
        } else {
            list[position] = newVal;
        }
    }

    public void replaceAll (int oldVal, int newVal) {
        for (int i=0; i < list.length-1; i++) 
            if (list[i] == oldVal)
                list[i] = newVal;
    }

    public int binarySearchD (int target) {
        int first = 0;
        int last = list.length - 1;
        int position = -1;

        while (first <= last) {
            int mid = (first + last) / 2;
            if (list[mid] > target) {
                first = mid + 1;
            } else if (list[mid] < target) {
                last= mid - 1;
            } else if (list[mid] == target) {
                position = mid;
                break;
            }
        }
        
        return position;
    }
} 