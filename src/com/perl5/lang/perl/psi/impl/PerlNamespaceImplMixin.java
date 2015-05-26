/*
 * Copyright 2015 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import com.perl5.lang.perl.psi.PerlNamespace;
import com.perl5.lang.perl.util.PerlPackageUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by hurricup on 25.05.2015.
 */
public class PerlNamespaceImplMixin extends PerlNamedElementImpl implements PerlNamespace
{
	public PerlNamespaceImplMixin(@NotNull ASTNode node){
		super(node);
	}

	@Override
	public PsiElement setName(@NotNull String name) throws IncorrectOperationException
	{
		// todo implement
		return super.setName(name);
	}

	@Nullable
	@Override
	public PsiElement getNameIdentifier()
	{
		return getFirstChild();
	}

	@NotNull
	@Override
	public String getName()
	{
		assert getNameIdentifier() != null;
		return PerlPackageUtil.canonicalPackageName(getNameIdentifier().getText());
	}
}