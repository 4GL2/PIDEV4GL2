package managedBeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import entities.Category;

@ManagedBean(name="data")
@ApplicationScoped
public class Data {
	
	public Category[] getCategories() {
		return Category.values();
	}

}
