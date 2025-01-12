ESSENTIAL_PROJECT="/project/"
ESSENTIAL_STAR_REF="/fsimb/common/genomes/saccharomyces_cerevisiae/ensembl/R64/canonical/index/star/2.7.3a/"
ESSENTIAL_GENESGTF="/fsimb/common/genomes/saccharomyces_cerevisiae/ensembl/R64/canonical/annotation/Saccharomyces_cerevisiae.R64-1-1.86.gtf"
ESSENTIAL_GENESBED="/fsimb/common/genomes/saccharomyces_cerevisiae/ensembl/R64/canonical/annotation/Saccharomyces_cerevisiae.R64-1-1.86.bed"
ESSENTIAL_CHROMSIZES="/fsimb/common/genomes/saccharomyces_cerevisiae/ensembl/R64/canonical/index/star/2.7.3a/chrNameLength.txt"  // chromosome sizes file
ESSENTIAL_FEATURETYPE="gene_biotype" //gencode uses gene_type; ensemble uses gene_biotype
ESSENTIAL_SAMPLE_PREFIX=""
ESSENTIAL_PAIRED="no"           // paired end design
ESSENTIAL_STRANDED="reverse"    // strandness: no|yes|reverse
ESSENTIAL_ORG="yeast"           // UCSC organism
ESSENTIAL_DB="sacCer3"          // UCSC assembly version
ESSENTIAL_READLENGTH=50         // added for STAR version > 2.4.1a
ESSENTIAL_THREADS=4             // number of threads for parallel tasks
ESSENTIAL_FRAGMENT_USAGE="no"   //should fragments be reconstituted? should always be no for rnaseq
ESSENTIAL_FRAGLEN=200           // mean length of library inserts (default 200)
ESSENTIAL_FILTER_CHR=""         //chromosomes to include in post-mapping analysis.
ESSENTIAL_BAMCOVERAGE="--binSize 1 --skipNonCoveredRegions --normalizeUsing CPM" // NO smoothing should be done for RNAseq
// size of bins (in bases)  and method to normalize the number of reads per bin to generate bigwig file.
ESSENTIAL_FASTQSCREEN_PERC=1    // contaminant filter, if a contaminant is consuming at least this percentage of reads in at least one sample, contaminant will be shown in report
ESSENTIAL_FASTQSCREEN_GENOME="Yeast::/fsimb/common/genomes/saccharomyces_cerevisiae/ensembl/R64/canonical/index/bowtie2/2.3.2/Saccharomyces_cerevisiae.R64-1-1.dna.toplevel"  //bowtie2 reference for the genome the samples are from, this is used for the fastqscreen
ESSENTIAL_FASTQSCREEN=ESSENTIAL_FASTQSCREEN_GENOME + ",PHIX::/fsimb/common/genomes/phix/19930428/NCBI/index/bowtie2/2.3.4.3/ncbi_phix,ERCC::/fsimb/common/genomes/ERCC/index/bowtie2/2.3.4.3/ERCC92,rRNA::/fsimb/common/genomes/contaminants/fastqscreen_references/rrna/v1/index/bowtie2/2.3.4.3/hs_mm_ce_dm_rn_dr_xt_rRNA,Mycoplasma::/fsimb/common/genomes/contaminants/fastqscreen_references/mycoplasma/v1/index/bowtie2/2.3.4.3/mycoplasma_all_ref,E.coli::/fsimb/common/genomes/Escherichia_coli/ensembl/full/index/bowtie2/Escherichia_coli_str_k_12_substr_dh10b.ASM1942v1.31.dna.genome,B.taurus::/fsimb/common/genomes/bos_taurus/ensembl/3.1/full/index/bowtie2/2.2.9/UMD3.1" //references for fastqscreen to use if run, this are our standard references please include yours 
// Adapter trimming with Cutadapt (additional adapter sequences for R1 and/or R2 can be specified in the cutadapt.header file)         
ESSENTIAL_ADAPTER_SEQUENCE="Nextera=CTGTCTCTTATACACATCT" // 3'adapter sequence for R1. 
ESSENTIAL_MINADAPTEROVERLAP=5
ESSENTIAL_MINREADLENGTH=30
ESSENTIAL_BASEQUALCUTOFF=20
ESSENTIAL_NEXTSEQTRIM=false

//global vars
PROJECT=ESSENTIAL_PROJECT
LOGS=PROJECT + "/logs"
MAPPED=PROJECT + "/mapped"
QC=PROJECT + "/qc"
REPORTS=PROJECT + "/reports"
RESULTS=PROJECT + "/results"
TMP=PROJECT + "/tmp"
TRACKS=PROJECT + "/tracks"
FUSION=PROJECT + "/fusion"
TRIMMED=PROJECT + "/trimmed"

//DESeq2 specific vars
ESSENTIAL_DESEQ2_FDR=0.01 // FDR filter used to retrieve the results in DESeq2
ESSENTIAL_DESEQ2_FC=1     // FC filter used to retrieve the result in DESeq2 (non log2)!
// optional pipeline stages to include
RUN_TRACKHUB=false
RUN_IN_PAIRED_END_MODE=(ESSENTIAL_PAIRED == "yes")
RUN_FASTQSCREEN=true
RUN_CUTADAPT=true
RUN_RMATS=true
