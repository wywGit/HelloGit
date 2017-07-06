package com.company.composite;


import java.util.ArrayList;
import java.util.List;

/**
 * ���
 * @author WYW
 *
 */
public class Composite extends Component {
	
	private String name;
	private List<Component> child = new ArrayList<Component>();
	public Composite(String name){
		this.name = name;
	}
	@Override
	public void addChild(Component c) {
		if(checkUnique(c)){
			c.setLevel(this.getLevel()+1);
			child.add(c);
			checkChildLevel(c);
		}else{
			System.out.println("�ýڵ��Ѿ�������:"+c.getName());
		}
	}
	/**
	 * ���ݸ��ڵ�Level��̬�ı��ӽڵ�Level
	 * @since 2015-2-11
	 * @return void
	 * @author wuyw
	 */
	private void checkChildLevel(Component comp) {
		List<Component> cList = comp.getChild();
		if(null!=cList && cList.size()!=0){
			for(Component c:cList){
				if(comp.getLevel()-c.getLevel()==1)
					break;
				else{
					c.setLevel(comp.getLevel()+1);
					checkChildLevel(c);
				}
			}
		}
		
	}
	/**
	 * ����ڵ��Ψһ�ԣ�ͬ���ڵ㣩
	 * @since 2015-2-11
	 * @param child
	 * @return
	 * @return boolean
	 * @author wuyw
	 */
	private boolean checkUnique(Component comp) {
		for(Component c:child){
			if(c.getName().equals(comp.getName())){
				return false;
			}
		}
		return true;
	}
	@Override
	public void removeChild(int index) {
		child.remove(index);
	}
	
	public void removeChild(Component c) {
		child.remove(c);
	}
	
	public void removeChild(String name) {
		for(Component c:child){
			if(c.getName().equals(name)){
				child.remove(c);
				break;
			}
		}
	}

	@Override
	public void printStruct(String prefix) {
		System.out.println(prefix + this.getLevel()+this.name);
		if(this.child!=null || this.child.size()==0){
			prefix += "\t";
			for(Component c:child){
				c.printStruct(prefix);
			}
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setChild(List<Component> child) {
		this.child = child;
	}
	@Override
	public List<Component> getChild() {
		return child;
	}
}
