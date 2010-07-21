/*
 * Copyright (c) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.data.client.generator;

import java.io.PrintWriter;

/**
 * @author Yaniv Inbar
 */
final class DocBuilder {

  String comment;

  int indentNumSpaces;

  DocBuilder container;

  int removedMinor;

  void generate(PrintWriter out) {
    boolean showSince = false;
    out.println(indent() + "/**");
    if (comment != null) {
      out.println(indent() + " * " + comment);
      out.println(indent() + " *");
    }
    if (showSince) {
      out.println(indent() + " * @since 1.0.");
    }
    out
        .println(
                indent()
                + " * @deprecated (scheduled to be removed in version 1.1) Copy into your own application");
    out.println(indent() + " */");
    out.println(indent() + "@Deprecated");
  }

  private String indent() {
    return AbstractJavaFileGenerator.indent(indentNumSpaces);
  }
}