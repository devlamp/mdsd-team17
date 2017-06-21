package mdsdteam17.mtt

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.EObject
import mdsdteam17.Modelcontainer
import mdsdteam17.repository.Interface

class ToJavaGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        
        for(e : resource.allContents.toIterable.filter(typeof(Interface))) {
        	fsa.generateFile(e.name + ".java", e.compile)
        }
    }
 
    def CharSequence compile(Interface e) '''
    
    interface «e.name» {
    	
    }
    '''
 
    def dispatch void compile(EObject m, IFileSystemAccess fsa) { }
}