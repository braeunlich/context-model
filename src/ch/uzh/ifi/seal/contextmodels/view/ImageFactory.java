package ch.uzh.ifi.seal.contextmodels.view;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.swt.graphics.Image;

@SuppressWarnings("restriction")
public class ImageFactory {
	
	private static JavaElementImageProvider imageProvider = new JavaElementImageProvider();
	
	public static Image getImage(IJavaElement element) {
		return imageProvider.getImageLabel(element, JavaElementImageProvider.OVERLAY_ICONS);
	}

}
