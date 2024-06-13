package com.geno1024.home.tool.sshpf.ds

data class ForwarderDef(
    val orientation: Orientation,
    val bind_address: String,
    val port: Int,
    val host: String,
    val hostport: Int
)
