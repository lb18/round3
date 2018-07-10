package testquestion1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import question1.MyCollection;

public class Test_MyCollection {
	
	MyCollection dynamicArray;

	@Test(description="Check Add functionality")
	public void Test1_Able_To_Add_New_Entry_In_Collection(){
		dynamicArray = new MyCollection(10);
		Assert.assertTrue(dynamicArray.add(5),"Assertion Failed : Not able to add number 5 in collection");
		Reporter.log("[INFO] : Assertion Passed : Add New Entry functionality is working fine", true);
	}
	
	@Test(description="Check Add functionality")
	public void Test2_Duplicate_Entry_In_Collection(){
		dynamicArray = new MyCollection(10);
		dynamicArray.add(4);
		dynamicArray.add(5);
		Assert.assertFalse(dynamicArray.add(4),"Assertion Failed : Add Duplicate Entry functionality is not working fine");
		Reporter.log("[INFO] : Assertion Passed : Not able to add duplicate number", true);
	}
	
	@Test(description="Check toString function")
	public void Test3_Get_Collection_Functionality(){
		dynamicArray = new MyCollection(10);
		Assert.assertEquals(dynamicArray.toString(), "{}","Assertion Failed : Not able to read collection");
		Reporter.log("[INFO] : Assertion Passed : Able to read collection", true);
	}
	
	@Test(description="Check Overflow Collection")
	public void Test4_DoubleCapacity(){
		dynamicArray = new MyCollection(3);
		dynamicArray.add(4);dynamicArray.add(5);dynamicArray.add(-4);dynamicArray.add(-5);
		dynamicArray.add(6);
		Assert.assertEquals(dynamicArray.toString(), "{4,5,-4,-5,6}","Assertion Failed : Not able to add number in collection once it get fulled");
		Reporter.log("[INFO] : Assertion Passed : Able to increase collection capacity", true);
	}
	
	@Test(description="Check remove functionality")
	public void Test5_Remove_Functionality_If_Entry_Already_Present(){
		dynamicArray = new MyCollection(3);
		dynamicArray.add(4);dynamicArray.add(5);dynamicArray.add(-4);dynamicArray.add(-5);
		dynamicArray.add(54);dynamicArray.add(95);dynamicArray.add(-14);dynamicArray.add(-15);
		Assert.assertTrue(dynamicArray.remove(54),"Assetion Failed : Not Able to delete entry from collection");
		Reporter.log("[INFO] : Assertion Passed : Able to remove entry from collection", true);
	}
	
	@Test(description="Check remove functionality")
	public void Test6_Remove_Functionality_If_Collection_Is_Empty(){
		dynamicArray = new MyCollection(3);
		Assert.assertFalse(dynamicArray.remove(54));
		Reporter.log("[INFO] : Assertion Passed : Can handle remove parameter if collection is empty", true);
	}
	
	@Test(description="Size of Collection")
	public void Test7_Collection_Length_Functionality(){
		dynamicArray = new MyCollection(6);
		dynamicArray.add(-4);dynamicArray.add(-5);
		dynamicArray.add(4);dynamicArray.add(5);
		dynamicArray.add(54);dynamicArray.add(95);
		Assert.assertEquals(dynamicArray.getCount(),6);
		Reporter.log("[INFO] : Assertion Passed : Collection length is correct", true);
	}
	
	@Test(description="Search Functionality")
	public void Test8_Search_Functionality_If_Enrty_Exists(){
		dynamicArray = new MyCollection(15);
		dynamicArray.add(4);dynamicArray.add(5);dynamicArray.add(-4);dynamicArray.add(-5);
		dynamicArray.add(54);dynamicArray.add(95);dynamicArray.add(-14);dynamicArray.add(-15);
		Assert.assertEquals(dynamicArray.search(54),4);
		Reporter.log("[INFO] : Assertion Passed : Function returns position of entry in collection", true);
	}
	
	@Test(description="Search Functionality")
	public void Test9_Search_Functionality_If_Enrty_Not_Exists(){
		dynamicArray = new MyCollection(10);
		dynamicArray.add(4);dynamicArray.add(5);dynamicArray.add(-4);dynamicArray.add(-5);
		Assert.assertEquals(dynamicArray.search(10),-1);
		Reporter.log("[INFO] : Assertion Passed : Function returns -1 if entry is not present", true);
	}
	
	@Test(description="Left Rotation Collection Functionality")
	public void Test10_Rotate_Array(){
		dynamicArray = new MyCollection(15);
		dynamicArray.add(4);dynamicArray.add(5);dynamicArray.add(-4);dynamicArray.add(-5);
		dynamicArray.add(54);dynamicArray.add(95);dynamicArray.add(-14);dynamicArray.add(-15);
		dynamicArray.rotate(2);
		Assert.assertEquals(dynamicArray.toString(),"{-4,-5,54,95,-14,-15,4,5}");
		Reporter.log("[INFO] : Assertion Passed : Rotation is working fine", true);
	}
}
