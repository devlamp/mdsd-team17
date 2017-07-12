package mdsdteam17.sirius.design;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import mdsdteam17.Mdsdteam17Factory;
import mdsdteam17.Modelcontainer;
import mdsdteam17.impl.ModelcontainerImpl;
import mdsdteam17.repository.ParameterType;
import mdsdteam17.repository.RepositoryPackageFactory;
import mdsdteam17.repository.Signature;
import mdsdteam17.repository.SignatureParameter;
import mdsdteam17.repository.Type;
import mdsdteam17.repository.impl.RepositoryPackageFactoryImpl;
import mdsdteam17.repository.impl.SignatureParameterImpl;

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
    
    
    public EObject editSignature(Signature self, String rawReturnType, String rawName, String rawParameters) {
    	//TODO: Regex to check signature
    	
    	self.getParameters().clear();
    	self.setName(rawName);
    	
    	Modelcontainer model = (Modelcontainer)self.eContainer().eContainer().eContainer();
    	
    	EList<Type> types = model.getTypes();
    	
    	//Set Return-Type
    	for(Type type : types) {
    		if (type.getName().equalsIgnoreCase(rawReturnType)) {
    			self.setReturnType(type);
    			break;
    		}
    	}
    	
    	String[] parameterList = rawParameters.split(",");
    	
    	for(int i=0; i < parameterList.length; i++) {
    		parameterList[i] = parameterList[i].trim();
    		
    		if (parameterList[i].equals("")) {
    			continue;
    		}
    		
    		String[] args = parameterList[i].split("(\\s)+");
    		
    		String typeString = args[0];
    		String nameString = args[1];
    		
    		SignatureParameter p = RepositoryPackageFactory.eINSTANCE.createSignatureParameter();
    		
    		p.setName(nameString);
    		
    		for(Type type : types) {
        		if (type.getName().equalsIgnoreCase(typeString) && !nameString.equals("void")) {
        			p.setType((ParameterType)type);
        			break;
        		}
        	}
    		
    		self.getParameters().add(p);
    		
    	}
    	
    	return self; 	
    }
    
    public String signatureString(Signature self) {
    	String parameters = "";
    	
    	
    	for(int i=0; i < self.getParameters().size(); i++) {
    		parameters += self.getParameters().get(i).getType().getName();
    		parameters += " ";
    		parameters += self.getParameters().get(i).getName();
    		
    		if (i < self.getParameters().size() - 1) {
    			parameters += ", ";
    		}
    	}
    	
    	return self.getReturnType().getName() + " " + self.getName() + "(" + parameters + ")"; 	
    }
    
}
