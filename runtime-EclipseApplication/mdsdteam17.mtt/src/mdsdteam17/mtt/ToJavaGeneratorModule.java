package mdsdteam17.mtt;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

public class ToJavaGeneratorModule extends AbstractGenericResourceRuntimeModule {
	@Override
    protected String getLanguageName() {
        return "sample.presentation.SampleEditorID";
    }
 
    @Override
    protected String getFileExtensions() {
        return "sample";
    }
 
    public Class<? extends IGenerator> bindIGenerator() {
        return ToJavaGenerator.class;
    }
 
    public Class<? extends ResourceSet> bindResourceSet() {
        return ResourceSetImpl.class;
    }
}
