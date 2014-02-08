package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.Folders;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestFolderCreation extends TestBase {

	@Test
	public void testFolderCreation () {
		String folder = "newFolder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	}
	
	@Test
	public void testVariousFolderCreation () {
		String folder1 = "newFolder1";
		String folder2 = "newFolder2";
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		Folders newFolders1 = app.getFolderHelper().getFolders();
		assertThat(newFolders1, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2), is(nullValue()));
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders1.withAdded(folder2)));
	}
	
	@Test
	public void testSameFolderCreation () {
		String folder = "newFolder3";
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder), is(nullValue()));
		Folders newFolders1 = app.getFolderHelper().getFolders();
		assertThat(newFolders1, equalTo(oldFolders.withAdded(folder)));
		assertThat(app.getFolderHelper().createFolder(folder), containsString("Duplicated folder name"));
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders1));
	}
}
