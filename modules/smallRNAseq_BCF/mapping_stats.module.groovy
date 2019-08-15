// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/smallRNAseq_BCF/mapping_stats.vars.groovy"

MappingStats = {
    doc title: "Statistics of mapping efficiency",
        desc:  "Counts the number of reads in the mapped bam, including total, unique, and mapped. Returns a plot of the results.",
        constraints: "Bam files produced by Bowtie 1.x. Might not work for other mappers/versions.",
        author: "Antonio Domingues, Anke Busch"

    output.dir = MAPPING_STATS_PLOTDIR

    def TOOL_ENV = prepare_tool_env("R", tools["R"]["version"], tools["R"]["runenv"]) + " && " +
                   prepare_tool_env("samtools", tools["samtools"]["version"], tools["samtools"]["runenv"])

    produce(MAPPING_STATS_PLOTDIR + "/totalReads.pdf", MAPPING_STATS_PLOTDIR + "/totalReads.png") {
        exec """
            ${TOOL_ENV} &&

            Rscript ${PIPELINE_ROOT}/tools/mapping_stats/mapping_stats_bowtie1_BCF.R ${MAPPING_STATS_DATADIR} ${MAPPING_STATS_PLOTDIR} ${ESSENTIAL_SAMPLE_PREFIX}
        ""","MappingStats"
    }
}
