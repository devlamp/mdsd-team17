package mdsdteam17.sirius.design;

import org.eclipse.emf.ecore.EObject;

import mdsdteam17.repository.Signature;

/**
 * The services class used by VSM.
 */
public class Services {
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }
    
    
    public String signatureString(Signature self) {
    	String parameters = "";
    	
    	
    	for(int i=0; i < self.getParameters().size(); i++) {
    		parameters += self.getParameters().get(i).getType().getName();
    		parameters += " ";
    		parameters += self.getParameters().get(i).getName();
    		
    		if (i < self.getParameters().size()) {
    			parameters += ", ";
    		}
    	}
    	
    	return self.getReturnType().getName() + " " + self.getName() + "(" + parameters + ")"; 	
    }
    
}
