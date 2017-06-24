package mdsdteam17.mtt;

import org.eclipse.ocl.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ToJavaGeneratorSetup implements ISetup {
 
    @Override
	public Injector createInjectorAndDoEMFRegistration() {
    	//OCLDelegateDomain.initialize(null);
    	//PivotStandaloneSetup.doSetup();
    	OCLinEcoreStandaloneSetup.doSetup();
		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new ToJavaGeneratorModule());
	}
    
	
    public void register(Injector injector) {
    	
    	//PivotStandaloneSetup.doSetup();
    //	CompleteOCLStandaloneSetup.doSetup();
    	
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
