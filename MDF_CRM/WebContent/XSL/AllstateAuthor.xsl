<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<!-- ========================= -->
	<!-- root element: projectteam -->
	<!-- ========================= -->
	<xsl:template match="FormXml">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="11.5in" page-width="8.5in" margin-top="0.25in" margin-bottom=".25in" margin-left=".5in" margin-right=".5in">
					<fo:region-body margin-top="0.5in" margin-bottom=".75in" />
					<fo:region-before extent="1in" />
					<fo:region-after extent="1in" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4" initial-page-number="1">
				<fo:static-content flow-name="xsl-region-before"><fo:block color="white">.</fo:block></fo:static-content>

				<fo:static-content flow-name="xsl-region-after">
					<fo:block color="white">.</fo:block>

				</fo:static-content>

				<fo:flow flow-name="xsl-region-body">

					<fo:block color="white">.</fo:block>

					<fo:block color="white">.</fo:block>
					<fo:block color="white">.</fo:block>

					<fo:block font-family="serif" font-size="12pt">&#160;</fo:block>
					<fo:block font-family="serif" font-size="12pt">&#160;</fo:block>
     				<fo:block font-family="serif" font-size="12pt">&#160;</fo:block>

					<fo:block color="white">.</fo:block>
					<fo:block font-family="serif" line-height="60pt" font-size="12pt">&#160;</fo:block>
					<fo:block color="white" line-height="5pt">.</fo:block>
					<fo:block color="white" line-height="5pt">.</fo:block>
					<fo:block font-family="serif" text-align="center" font-size="12pt"><xsl:value-of select="companyName" />&#160; AUTHORIZATION FORM</fo:block>

					<fo:block font-family="serif" line-height="20pt" font-size="12pt">&#160;</fo:block>

					<fo:block font-family="serif" font-size="12pt">APPLICATION NUMBER:&#160;&#160;&#160;<xsl:value-of select="applicationNumber" /></fo:block>

					<fo:block font-family="serif" line-height="20pt" font-size="12pt">&#160;</fo:block>

					<fo:block font-family="serif" font-size="12pt">I,<xsl:value-of select="nameInsured" />
					, request that my automobile </fo:block>
                   	<fo:block font-family="serif" font-size="12pt">
						insurance policy be written by <xsl:value-of select="toCompany" />.  I request that no
						coverage be afforded by <xsl:value-of select="fromCompany" />, and that all coverage
						under the above application number be provided by <xsl:value-of select="toCompany" />.
					</fo:block>
					<fo:table table-layout="fixed">
					<fo:table-column column-width="3.5in" />
					<fo:table-column column-width="3.5in" />

						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt">Signature of the insured(s):</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt"> </fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt">Named Insured:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt"><xsl:value-of select="nameInsured" /></fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt">Date Signed:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt"></fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt">Signature of Agent:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt">_</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt">Agent Name:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt"><xsl:value-of select="agentName" /></fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt">Date Signed:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-family="serif" font-size="12pt"></fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>

					</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>