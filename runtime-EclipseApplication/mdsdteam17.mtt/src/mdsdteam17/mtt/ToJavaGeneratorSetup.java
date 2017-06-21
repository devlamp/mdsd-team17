package mdsdteam17.mtt;

import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ToJavaGeneratorSetup implements ISetup {
 
    @Override
    public Injector createInjectorAndDoEMFRegistration() {
        return Guice.createInjector(new ToJavaGeneratorModule());
    }
}
