package mdsdteam17.mtt

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.EObject
import mdsdteam17.Modelcontainer

class ToJavaGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        for (EObject o : resource.contents) {
            o.compile(fsa)
        }
    }
 
    def dispatch void compile(Modelcontainer m, IFileSystemAccess fsa) {
        
    }
 

 
    def dispatch void compile(EObject m, IFileSystemAccess fsa) { }
}