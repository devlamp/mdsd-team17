package mdsdteam17.mtt

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.EObject
import mdsdteam17.Modelcontainer
import mdsdteam17.repository.Interface
import mdsdteam17.repository.Repository
import mdsdteam17.repository.Signature
import mdsdteam17.repository.ParameterType
import mdsdteam17.repository.SignatureParameter
import mdsdteam17.repository.Component
import com.google.inject.Inject
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import java.util.Set
import java.util.ArrayList
import java.util.List

class ToJavaGenerator implements IGenerator {
	@Inject extension IQualifiedNameProvider
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
	    
	    for(e : resource.allContents.toIterable.filter(typeof(Repository))) {
        fsa.generateFile("Helper.java", e.helper);
        }
        for(e : resource.allContents.toIterable.filter(typeof(Interface))) {
        	fsa.generateFile(e.name + ".java", e.compile)
        }
        for(e : resource.allContents.toIterable.filter(typeof(Component))) {
        	fsa.generateFile(e.name + "Impl.java", e.compile)
        }
    }
    
    def Set<Interface> getAllInterfaces(Component c) {
    		var output = new ArrayList<Interface>();
    		output.addAll(c.requiredInterfaces);
    		output.addAll(c.providedInterfaces);
    		return output.toSet();
    }
    
    def CharSequence helper(Repository e) '''
    package «e.name»
    
    static public class Helper {
    	
    	static public void assertNull(object o) {
    	
    	}
    	
    	static public void assertNotNull(object o) {
    	
    	}
    }
    
    '''
 
    def CharSequence compile(Interface e) '''
    package «(e.eContainer as Repository).name»;
    
    interface «e.name» {
    
    	«FOR s : e.eContents SEPARATOR '\n'»
    	«IF s instanceof Signature»
    	«s.returnType.name» «s.name»(«FOR p : s.parameters SEPARATOR ','»«p.type.name» «p.type.name»«ENDFOR»);
    	«ENDIF»
    	«ENDFOR»
    }
    '''
    
    def CharSequence compile(Component e) '''
    package «e.name»;
    
    «FOR s : getAllInterfaces(e)»
    	import «(s.eContainer as Repository).name».«s.name»;
    «ENDFOR»
    
    public class «e.name»Impl implements «FOR i : e.providedInterfaces SEPARATOR ','»«i.name»«ENDFOR» {
    	
    	«FOR r : e.requiredInterfaces SEPARATOR '\n'»
    			«r.name» «r.name.toFirstLower()»;
    			
    			public void set«r.name»(«r.name» «r.name.toFirstLower()») {
    				Helper.assertNull(this.«r.name.toFirstLower()»);
    				this.«r.name.toFirstLower()» = «r.name.toFirstLower()»;
    				
    			}
    	«ENDFOR»
    	
    	«FOR i : e.providedInterfaces SEPARATOR '\n'»
    	«FOR b : i.signatures SEPARATOR '\n'»
    			//Implementing «b.name» from interface «i.name»
    			@Override
    			public «b.returnType.name» «b.name»(«FOR p : b.parameters SEPARATOR ','»«p.type.name»«ENDFOR») {
    				«FOR r : e.requiredInterfaces»
    				Helper.assertNotNull(this.«r.name.toFirstLower()»);
    				«ENDFOR»
    				//TODO: Insert code here
    			}
    	«ENDFOR»
    	«ENDFOR»
    }
    '''
 
    def dispatch void compile(EObject m, IFileSystemAccess fsa) { }
}