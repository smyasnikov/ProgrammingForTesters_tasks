package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.fw.Folders;

public class TestFolderRemoval extends TestBase{
	
	@Test
	public void RemoveRandomFolder() {
		Folders oldFolders = app.getFolderHelper().getFolders();
		int folderQty = app.getFolderHelper().getTreeSize();
		if (folderQty == 0) 
			throw new Error("Folders are missing");
		Random rnd = new Random();
		int index = rnd.nextInt(folderQty);
		app.getFolderHelper().removeFolderByIndex(index);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.without(index)));
	}

}
