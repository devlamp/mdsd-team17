package mdsdteam17.mtt;

import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ToJavaGeneratorSetup implements ISetup {
 
    @Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new ToJavaGeneratorModule());
	}
    
    public void register(Injector injector) {
    	
    	//PivotStandaloneSetup.doSetup();
    	CompleteOCLStandaloneSetup.doSetup();
    	
    	/*
    	OCLDelegateDomain.initialize(null);
    	OCLinEcoreStandaloneSetup.doSetup();
    	EssentialOCLStandaloneSetup.doSetup();
    	OCLstdlib.install();
    	*/
    	/*
    	String oclDelegateURI = OCLDelegateDomain.OCL_DELEGATE_URI;
    	EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
    	    new OCLInvocationDelegateFactory.Global());
    	EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
    	    new OCLSettingDelegateFactory.Global());
    	EValidator.ValidationDelegate.Registry.INSTANCE.put(oclDelegateURI,
    	    new OCLValidationDelegateFactory.Global());*/
    }
}
