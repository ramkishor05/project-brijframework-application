package org.brijframework.store.inventory;
import java.lang.reflect.InvocationTargetException;

import org.brijframework.beans.collection.ListBean;
import org.brijframework.beans.collection.MapBean;
import org.brijframework.core.bulider.GraphBulider;
import org.brijframework.db.builder.DBBuilder;
import org.brijframework.db.processor.DBDataProcessor;

import com.sun.research.ws.wadl.Method;

import sun.reflect.MethodAccessor;
import sun.reflect.ReflectionFactory;
public class InvTestMain {

	public static void main(String[] args) {
		beanBuild();
		//associationBuild();
		// deepAssociationBuild();
		// collectionBuild();
		// deepCollectionBuild();
		// addToObjectBuild();
		//addToColletionBuild();
	}

	public static void beanBuild() {
		MapBean<String, Object> eoCategory = new MapBean<>("uniqueID_ADD~name~eoCategoryGroup~eoInvApp", 723, "Veg update", 74,45);
		DBBuilder builder = DBBuilder.getBuilder(EOCategory.class);
		System.out.println("SSJSJ");
		Object object = builder.beanBuild(eoCategory);
		builder.actionPerformed();
		System.out.println(GraphBulider.getBulider(object).printFullGraph());
		//Object object=builder.deleteObject(eoCategory);
		//System.out.println(GraphBulider.getBulider(object).printFullGraph());
	}

	public static void associationBuild() {
		MapBean<String, Object> eoCategory = new MapBean<>("uniqueID_ADD~name~eoCategoryGroup~eoInvApp", 0, "Veg S", 74,45);
		EOIngr eoingr = DBDataProcessor.getProcessor().findObject(EOIngr.class, "uniqueID", 468);
		DBBuilder builder = DBBuilder.getBuilder(EOIngr.class);
		Object object = builder.associationBuild(eoingr, "eoCategory", eoCategory);
		//builder.actionPerformed();
		System.out.println(GraphBulider.getBulider(object).printFullGraph());
	}

	public static void deepAssociationBuild() {
		MapBean<String, Object> eoCategory = new MapBean<>("uniqueID_ADD~name~eoCategoryGroup~eoInvApp", 0, "Veg S", 74,
				45);
		MapBean<String, Object> eoIngr = new MapBean<>("uniqueID_ADD~name~eoCategory~eoInvApp", 0, "Veg S", eoCategory,
				45);
		EOInvApp eoInvApp = DBDataProcessor.getProcessor().findObject(EOInvApp.class, "uniqueID", 45);
		DBBuilder builder = DBBuilder.getBuilder(EOInvApp.class);
		Object object = builder.associationBuild(eoInvApp, "eoIngrArray", eoIngr);
		builder.actionPerformed();
		System.out.println(GraphBulider.getBulider(object).printFullGraph());
	}

	public static void collectionBuild() {
		MapBean<String, Object> eoCategory1 = new MapBean<>("uniqueID_UPDATE~name~eoCategoryGroup~eoInvApp", 631,
				"Veg S", 74, 45);
		MapBean<String, Object> eoCategory2 = new MapBean<>("uniqueID_ADD~name~eoCategoryGroup~eoInvApp", 631, "Veg S",
				74, 45);
		EOIngr eoingr = DBDataProcessor.getProcessor().findObject(EOIngr.class, "uniqueID", 468);
		DBBuilder builder = DBBuilder.getBuilder(eoingr);
		Object object = builder.addToRel("eoCategory", new ListBean<>(eoCategory1, eoCategory2));
		builder.actionPerformed();
		System.out.println(GraphBulider.getBulider(object).printFullGraph());
	}

	public static void deepCollectionBuild() {
		MapBean<String, Object> eoCategory1 = new MapBean<>("uniqueID_UPDATE~name~eoCategoryGroup~eoInvApp", 631,
				"Veg S", 74, 45);
		MapBean<String, Object> eoCategory2 = new MapBean<>("uniqueID_ADD~name~eoCategoryGroup~eoInvApp", 631, "Veg S",
				74, 45);
		MapBean<String, Object> eoIngr1 = new MapBean<>("uniqueID~name~eoCategory~eoInvApp", 0, "Veg S", eoCategory1,
				45);
		MapBean<String, Object> eoIngr2 = new MapBean<>("uniqueID~name~eoCategory~eoInvApp", 0, "Veg S", eoCategory2,
				45);
		EOInvApp eoInvApp = DBDataProcessor.getProcessor().findObject(EOInvApp.class, "uniqueID", 45);
		DBBuilder builder = DBBuilder.getBuilder(EOIngr.class);
		Object object = builder.collectionBuild(eoInvApp, "eoIngrArray", new ListBean<>(eoIngr1, eoIngr2));
		builder.actionPerformed();
		System.out.println(GraphBulider.getBulider(object).printFullGraph());
	}

	public static void addToObjectBuild() {
		MapBean<String, Object> eoCategory = new MapBean<>("uniqueID~name~eoCategoryGroup~eoInvApp", 0, "Veg S", 74,
				45);
		EOIngr eoingr = DBDataProcessor.getProcessor().findObject(EOIngr.class, "uniqueID", 468);
		DBBuilder.getBuilder(eoingr).addToRel("eoCategory", eoCategory);
		System.out.println(GraphBulider.getBulider(eoingr).printFullGraph());
	}

	public static void addToColletionBuild() {
		MapBean<String, Object> eoCategory1 = new MapBean<>("uniqueID_ADD~name~eoCategoryGroup~eoInvApp", 0, "Veg 1",
				74, 45);
		MapBean<String, Object> eoCategory2 = new MapBean<>("uniqueID_ADD~name~eoCategoryGroup~eoInvApp", 0, "Veg 2",
				74, 45);
		MapBean<String, Object> eoIngr1 = new MapBean<>("uniqueID~name~eoCategory~eoInvApp", 0, "Veg 1", eoCategory1,
				45);
		MapBean<String, Object> eoIngr2 = new MapBean<>("uniqueID~name~eoCategory~eoInvApp", 0, "Veg 2", eoCategory2,
				45);
		EOInvApp eoInvApp = DBDataProcessor.getProcessor().findObject(EOInvApp.class, "uniqueID", 45);
		DBBuilder builder =DBBuilder.getBuilder(eoInvApp);
		builder.addToRel("eoIngrArray", eoIngr1);
		builder.actionPerformed();
	}

	public static void updateToBuild() {
		MapBean<String, Object> eoCategory = new MapBean<>("uniqueID~name~eoCategoryGroup~eoInvApp", 0, "Veg S", 74,
				45);
		EOIngr eoingr = DBDataProcessor.getProcessor().findObject(EOIngr.class, "uniqueID", 468);
		DBBuilder.getBuilder(eoingr).updateToRel("eoCategory", eoCategory);
	}

}

class ExecutableMain implements MethodAccessor{

	ExecutableMain() {
		super();
	}

	public Object invoke(Object arg0, Object[] arg1) throws IllegalArgumentException, InvocationTargetException {
		System.out.println("solod");
		return "adad";
	}
	
}
