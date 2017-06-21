package mdsdteam17.mtt;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

public class ToJavaGeneratorSupport extends AbstractGenericResourceSupport {
	
    @Override
    protected Module createGuiceModule() {
        return new ToJavaGeneratorModule();
    }
}