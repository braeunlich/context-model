package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import org.eclipse.jdt.core.Flags;

public enum JavaMethodAccessModifier {

	DEFAULT("methdef_obj"), 
	PUBLIC("methpub_obj"), 
	PRIVATE("methpri_obj"), 
	PROTECTED("methpro_obj");
	
	private JavaMethodAccessModifier(String icon) {
		this.icon = icon;
	}
	
	public static JavaMethodAccessModifier parseJDTFlags(int jdtFlag) {
		if(Flags.isPackageDefault(jdtFlag)) {
			return DEFAULT;
		} else if(Flags.isPrivate(jdtFlag)) {
			return PRIVATE;
		} else if(Flags.isPublic(jdtFlag)) {
			return PUBLIC;
		} else if(Flags.isProtected(jdtFlag)) {
			return PROTECTED;
		}
		
		return null;
	}
	
	private String icon;
	
	public String getIcon() {
		return icon;
	}
	
}
