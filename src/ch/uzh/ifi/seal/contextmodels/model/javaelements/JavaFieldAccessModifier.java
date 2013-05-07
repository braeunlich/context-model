package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import org.eclipse.jdt.core.Flags;

public enum JavaFieldAccessModifier {

	DEFAULT("field_default_obj"), 
	PUBLIC("field_public_obj"), 
	PRIVATE("field_private_obj"), 
	PROTECTED("field_protected_obj");

	private JavaFieldAccessModifier(String icon) {
		this.icon = icon;
	}

	private String icon;

	public String getIcon() {
		return icon;
	}

	public static JavaFieldAccessModifier parseJDTFlags(int jdtFlag) {
		if (Flags.isPackageDefault(jdtFlag)) {
			return DEFAULT;
		} else if (Flags.isPrivate(jdtFlag)) {
			return PRIVATE;
		} else if (Flags.isPublic(jdtFlag)) {
			return PUBLIC;
		} else if (Flags.isProtected(jdtFlag)) {
			return PROTECTED;
		}

		return null;
	}
}
