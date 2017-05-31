/*
 * generated by Xtext 2.10.0
 */
package mdsdteam17.cmdsl.tests

import com.google.inject.Inject
import mdsdteam17.Modelcontainer
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(ComponentModelInjectorProvider)
class ComponentModelParsingTest{

	@Inject
	ParseHelper<Modelcontainer> parseHelper

	@Test 
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
	}

}