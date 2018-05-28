package com.test.memo;

import java.util.List;

public interface IMemo {



	int add(MemoDTO dto);

	List<MemoDTO> list();

	MemoDTO get(String seq);

	int editmemo(MemoDTO dto);

}
