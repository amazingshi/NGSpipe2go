// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/miscellaneous/collect_tool_versions.vars.groovy"

collectToolVersions = {
	doc title: "collectToolVersions",
		desc:  "so far, a dumb dump of the `tools` map",
		constraints: "needs the tool map defined in PIPELINE_ROOT/pipelines/<pipeline>/tools.groovy",
		bpipe_version: "tested with bpipe 0.9.9.8",
		author: "Sergi Sayols"
	
    File f = new File(collectToolVersions_vars.outdir + "/tool_versions.txt")
    f.write "tool\tenv\tversion\n"
    tools.each { tool, x -> f << "$tool\t$x.runenv\t$x.version\n" }
}
