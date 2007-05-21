/*
 * FindBugs - Find Bugs in Java programs
 * Copyright (C) 2006, University of Maryland
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package edu.umd.cs.findbugs.gui2;

import java.io.File;

enum SaveType {NOT_KNOWN, PROJECT, XML_ANALYSIS, FBP_FILE, FBA_FILE;
public FindBugsFileFilter getFilter() {
	switch (this) {
	case PROJECT:
		return FindBugsProjectFileFilter.INSTANCE;
	case XML_ANALYSIS:
		return FindBugsAnalysisFileFilter.INSTANCE;
	case FBP_FILE:
		return FindBugsFBPFileFilter.INSTANCE;
	case FBA_FILE:
		return FindBugsFBPFileFilter.INSTANCE;
	default: 
			throw new IllegalArgumentException("No filter for type NOT_UNKNOWN");
	}
}
public String getFileExtension() {
	switch (this) {
	case PROJECT:
		return "";
	case XML_ANALYSIS:
		return ".xml";
	case FBP_FILE:
		return ".fbp";
	case FBA_FILE:
		return ".fba";
	default: 
			throw new IllegalArgumentException("No filter for type NOT_UNKNOWN");
	}
}
public static SaveType forFile(File f) {
	String name = f.getName();
	if (name.endsWith(".fbp")) return FBP_FILE;
	if (name.endsWith(".fba")) return FBA_FILE;
	if (name.endsWith(".xml")) return XML_ANALYSIS;
	if (f.isDirectory()) return PROJECT;
	return NOT_KNOWN;
}
}