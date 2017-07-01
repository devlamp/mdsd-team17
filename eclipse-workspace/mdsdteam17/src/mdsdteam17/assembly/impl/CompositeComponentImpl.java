/**
 */
package mdsdteam17.assembly.impl;

import java.util.Collection;

import mdsdteam17.assembly.AssemblyConnector;
import mdsdteam17.assembly.AssemblyContext;
import mdsdteam17.assembly.AssemblyPackagePackage;
import mdsdteam17.assembly.CompositeComponent;
import mdsdteam17.assembly.DelegationConnector;
import mdsdteam17.assembly.DelegationType;
import mdsdteam17.repository.Interface;
import mdsdteam17.repository.RepositoryPackagePackage;
import mdsdteam17.repository.impl.ComponentImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mdsdteam17.assembly.impl.CompositeComponentImpl#getAssemblyconnectors <em>Assemblyconnectors</em>}</li>
 *   <li>{@link mdsdteam17.assembly.impl.CompositeComponentImpl#getDelegationconnectors <em>Delegationconnectors</em>}</li>
 *   <li>{@link mdsdteam17.assembly.impl.CompositeComponentImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeComponentImpl extends ComponentImpl implements CompositeComponent {
	/**
	 * The cached value of the '{@link #getAssemblyconnectors() <em>Assemblyconnectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyconnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<AssemblyConnector> assemblyconnectors;

	/**
	 * The cached value of the '{@link #getDelegationconnectors() <em>Delegationconnectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegationconnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<DelegationConnector> delegationconnectors;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<AssemblyContext> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssemblyPackagePackage.Literals.COMPOSITE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssemblyConnector> getAssemblyconnectors() {
		if (assemblyconnectors == null) {
			assemblyconnectors = new EObjectContainmentEList<AssemblyConnector>(AssemblyConnector.class, this, AssemblyPackagePackage.COMPOSITE_COMPONENT__ASSEMBLYCONNECTORS);
		}
		return assemblyconnectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DelegationConnector> getDelegationconnectors() {
		if (delegationconnectors == null) {
			delegationconnectors = new EObjectContainmentEList<DelegationConnector>(DelegationConnector.class, this, AssemblyPackagePackage.COMPOSITE_COMPONENT__DELEGATIONCONNECTORS);
		}
		return delegationconnectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssemblyContext> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<AssemblyContext>(AssemblyContext.class, this, AssemblyPackagePackage.COMPOSITE_COMPONENT__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ASSEMBLYCONNECTORS:
				return ((InternalEList<?>)getAssemblyconnectors()).basicRemove(otherEnd, msgs);
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__DELEGATIONCONNECTORS:
				return ((InternalEList<?>)getDelegationconnectors()).basicRemove(otherEnd, msgs);
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ASSEMBLYCONNECTORS:
				return getAssemblyconnectors();
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__DELEGATIONCONNECTORS:
				return getDelegationconnectors();
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ELEMENTS:
				return getElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ASSEMBLYCONNECTORS:
				getAssemblyconnectors().clear();
				getAssemblyconnectors().addAll((Collection<? extends AssemblyConnector>)newValue);
				return;
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__DELEGATIONCONNECTORS:
				getDelegationconnectors().clear();
				getDelegationconnectors().addAll((Collection<? extends DelegationConnector>)newValue);
				return;
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends AssemblyContext>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ASSEMBLYCONNECTORS:
				getAssemblyconnectors().clear();
				return;
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__DELEGATIONCONNECTORS:
				getDelegationconnectors().clear();
				return;
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ELEMENTS:
				getElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ASSEMBLYCONNECTORS:
				return assemblyconnectors != null && !assemblyconnectors.isEmpty();
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__DELEGATIONCONNECTORS:
				return delegationconnectors != null && !delegationconnectors.isEmpty();
			case AssemblyPackagePackage.COMPOSITE_COMPONENT__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	private EList<Interface> requiredInterfaces;
	@Override
	public EList<Interface> getRequiredInterfaces() {
		if (requiredInterfaces != null) {
			return requiredInterfaces;
		}
		
		requiredInterfaces = new EObjectResolvingEList<Interface>(Interface.class, this, RepositoryPackagePackage.COMPONENT__REQUIRED_INTERFACES);
		
		for(DelegationConnector delCon: this.getDelegationconnectors()) {
			if (delCon.getDelegationType() == DelegationType.REQUIRED) {
				Interface intf = delCon.getInterface();
				if (intf != null) {
					requiredInterfaces.add(intf);
				}
			}
		}
		
		return requiredInterfaces;
	}
	
	private EList<Interface> providedInterfaces;
	@Override
	public EList<Interface> getProvidedInterfaces() {
		if (providedInterfaces != null) {
			return providedInterfaces;
		}
		
		
		providedInterfaces = new EObjectResolvingEList<Interface>(Interface.class, this, RepositoryPackagePackage.COMPONENT__PROVIDED_INTERFACES);
		
		for(DelegationConnector delCon: this.getDelegationconnectors()) {
			if (delCon.getDelegationType() == DelegationType.PROVIDED) {
				Interface intf = delCon.getInterface();
				if (intf != null) {
					providedInterfaces.add(intf);
				}
			}
		}
		
		return providedInterfaces;
	}
} //CompositeComponentImpl
