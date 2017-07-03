package com.pb.entity;

public class EXFactory {
   public static EX create(int id){
	   switch(id){
	   case 1:
		   return new CD();		   
	   case 2:
		   return new Bag();		  
	   case 3:
		   return new Pen();		 
	  default:
			  return null;
	   }
   }
}
