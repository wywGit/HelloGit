package com.company.composite;

/**
 * р╤вс
 * @author WYW
 *
 */
public class Leaf extends Component {
	
	private String name;
	public Leaf(String name){
		this.name = name;
	}
	public void printStruct(String prefix) {
		System.out.println(prefix + this.getLevel()+this.name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
