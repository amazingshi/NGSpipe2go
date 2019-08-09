// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/NGS/filterchromosomes.vars.groovy"

FilterChr = {
    doc title: "FilterChr",
        desc:  "When mapping to full genome, including unassembled contigs, remove those extra contiguous before proceeding for further analysis. The goal is to increase speed and decrease disk space usage. Source: https://www.biostars.org/p/171791/#171819",
        constraints: "Requires a file with the list of chromosomes to keep.",
        bpipe_version: "tested with bpipe 0.9.9.3.slurm",
        author: "António Domingues"

    output.dir=MAPPED

    transform(".bam") to (".chrOnly.bam") {
        exec """
            chroms=\$(cut -f1 $FILTER_CHR_FILE) && 

            samtools view -@ $FILTER_CHR_THREADS -b $input \$chroms > $output &&
            samtools index $output
        ""","FilterChr"
    }
}

