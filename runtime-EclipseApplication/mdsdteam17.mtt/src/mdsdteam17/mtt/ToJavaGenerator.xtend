package mdsdteam17.mtt

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.EObject
import mdsdteam17.repository.Interface
import mdsdteam17.repository.Repository
import mdsdteam17.repository.Signature
import mdsdteam17.repository.Component
import java.util.Set
import java.util.ArrayList

class ToJavaGenerator implements IGenerator {
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
	    
	    for(e : resource.allContents.toIterable.filter(typeof(Repository))) {
        fsa.generateFile(e.package_name + "/Helper.java", e.helper);
        }
        for(e : resource.allContents.toIterable.filter(typeof(Interface))) {
        	fsa.generateFile(e.package_name + "/" + e.jname + ".java", e.compile)
        }
        for(e : resource.allContents.toIterable.filter(typeof(Component))) {
        	fsa.generateFile(e.package_name + "/" + e.name + "Impl.java", e.compile)
        }
    }
    
    def Set<Interface> getAllInterfaces(Component c) {
    		var output = new ArrayList<Interface>();
    		output.addAll(c.requiredInterfaces);
    		output.addAll(c.providedInterfaces);
    		return output.toSet();
    }
    
    def CharSequence helper(Repository e) '''
    package «e.package_name»;
    
    static public class Helper {
    	
    	static public void assertNull(Object o) {
    	
    	}
    	
    	static public void assertNotNull(Object o) {
    	
    	}
    }
    
    '''
 
 	def CharSequence package_name(Repository r)'''
 	«r.name.toLowerCase»'''
 	
 	def CharSequence package_name(Component c)'''
 	«c.name.toLowerCase»'''
 	
 	def CharSequence package_name(Interface i)'''
 	«(i.eContainer as Repository).package_name»'''
 	
 	
    def CharSequence compile(Interface e) '''
    package «e.package_name»;
    
    public interface «e.jname» {
    
    	«FOR s : e.eContents SEPARATOR '\n'»
    	«IF s instanceof Signature»
    	«s.compile»;
    	«ENDIF»
    	«ENDFOR»
    }
    '''
    
    def CharSequence jname(Interface e) '''
    I«e.name»'''
    
    def CharSequence jname_lower(Interface e) '''
    i«e.name»'''
    
    def CharSequence compile(Signature s) '''
    «s.returnType.name» «s.name»(«FOR p : s.parameters SEPARATOR ','»«p.type.name»«ENDFOR»)'''
    
    def CharSequence compile(Component e) '''
    package «e.package_name»;
    «IF e.requiredInterfaces.length > 0»
    import «(e.eContainer as Repository).package_name».Helper;
    «ENDIF»
    «FOR s : getAllInterfaces(e)»
    	import «s.package_name».«s.jname»;
    «ENDFOR»
    
    public class «e.name»Impl implements «FOR i : e.providedInterfaces SEPARATOR ','»«i.jname»«ENDFOR» {
    	
    	«FOR r : e.requiredInterfaces SEPARATOR '\n'»
    			«r.jname» «r.jname_lower»;
    			
    			public void set«r.jname»(«r.jname» «r.jname_lower») {
    				Helper.assertNull(this.«r.jname_lower»);
    				this.«r.jname_lower» = «r.jname_lower»;
    				
    			}
    	«ENDFOR»
    	
    	«FOR i : e.providedInterfaces SEPARATOR '\n'»
    	«FOR b : i.signatures SEPARATOR '\n'»
    			//Implementing «b.name» from interface «i.jname»
    			@Override
    			public «b.compile» {
    				«FOR r : e.requiredInterfaces»
    				Helper.assertNotNull(this.«r.jname_lower»);
    				«ENDFOR»
    				//TODO: Insert code here
    			}
    	«ENDFOR»
    	«ENDFOR»
    }
    '''
 
    def dispatch void compile(EObject m, IFileSystemAccess fsa) { }
}