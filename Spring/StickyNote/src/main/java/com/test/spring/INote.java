package com.test.spring;

import java.util.List;

public interface INote {

	int add(NoteDTO dto);

	List<NoteDTO> list();

	NoteDTO get();

	int del(String seq);

}
