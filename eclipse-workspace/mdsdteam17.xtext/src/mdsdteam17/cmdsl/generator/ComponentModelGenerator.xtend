/*
 * generated by Xtext 2.10.0
 */
package mdsdteam17.cmdsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.ecore.resource.ResourceSet
import mdsdteam17.cmdsl.ComponentModelStandaloneSetup

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ComponentModelGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val injector = new ComponentModelStandaloneSetup().createInjectorAndDoEMFRegistration();
		val resourceSet = injector.getInstance(typeof(ResourceSet));
		
		val xmiResource = resourceSet.createResource(fsa.getURI("ComponentModel.xmi"));
		xmiResource.getContents().add(resource.getContents().get(0));
		xmiResource.save(null);		
	}
}