package com.bridgelabs.fs.algorithmprograms;

import java.util.ArrayList;

import com.bridglabz.utility.InputUtility;

public class TaskScheduler{
	  public static void main(String args[]) {

		  int n = InputUtility.intVal();
		    int max = 0;
		    ArrayList<Schedule> sch = new ArrayList<Schedule>();
		    for(int i = 0; i < n; i++) {
		        int deadLine = InputUtility.intVal();
		        int taskCompletionTime = InputUtility.intVal();
		        Schedule s = new Schedule(deadLine, taskCompletionTime);
		        int j = i-1;
		        while(j >= 0 && sch.get(j).deadLine > s.deadLine) {
		            Schedule s1 = sch.get(j);
		            if(s1.deadLine <= s.deadLine)
		            	break;
		            s1.done += s.taskCompletionTime;
		            max = Math.max(max, s1.done - s1.deadLine);
		            j--;
		        }
		        sch.add(j+1, s);
		        if(j < 0)
		            s.done = s.taskCompletionTime;
		        else
		            s.done = sch.get(j).done + s.taskCompletionTime;

		        max = Math.max(max, s.done - s.deadLine);

		        System.out.println(max);
		     }
		  }
		}