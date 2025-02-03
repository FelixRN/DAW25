package com.proyect02.view;

import com.proyect02.utils.TerminalUtils;

public class MainTerminalView implements IMainView{
	
	@Override
	public void hello() {
		TerminalUtils.output("HelloWorld");
	}
}
