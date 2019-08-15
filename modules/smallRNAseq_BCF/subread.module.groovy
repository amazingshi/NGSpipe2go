// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/smallRNAseq_BCF/subread.vars.groovy"

SubreadCount = {
    doc title: "SubreadCount",
        desc:  "Counting reads in features with feature-count out of the subread package",
        constraints: "Default: strand specific counting.",
        author: "Oliver Drechsel, Antonio Domingues, Anke Busch"

    output.dir = SUBREAD_OUTDIR
    def SUBREAD_FLAGS = SUBREAD_CORES    + " " +
                        SUBREAD_GENESGTF + " " +
                        SUBREAD_EXTRA

    if(SUBREAD_PAIRED == "yes") {
        SUBREAD_FLAGS = " -p " + SUBREAD_FLAGS
    }

    // no|yes|reverse
    if(SUBREAD_STRANDED == "no") {
        SUBREAD_FLAGS = " -s 0 " + SUBREAD_FLAGS
    }
    else if (SUBREAD_STRANDED == "yes") {
        SUBREAD_FLAGS = " -s 1 " + SUBREAD_FLAGS
    }
    else {
        SUBREAD_FLAGS = " -s 2 " + SUBREAD_FLAGS
    }

    def TOOL_ENV = prepare_tool_env("subread", tools["subread"]["version"], tools["subread"]["runenv"])

    // run the chunk
    transform(".bam") to (".raw_readcounts.tsv") {
        exec """
            ${TOOL_ENV} &&

            featureCounts $SUBREAD_FLAGS -o $output $input 2> ${output.prefix}_subreadlog.stderr
        ""","SubreadCount"
    }
}
