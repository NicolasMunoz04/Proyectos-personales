# Additional clean files
cmake_minimum_required(VERSION 3.16)

if("${CONFIG}" STREQUAL "" OR "${CONFIG}" STREQUAL "Release")
  file(REMOVE_RECURSE
  "Bloc_autogen"
  "CMakeFiles\\Bloc_autogen.dir\\AutogenUsed.txt"
  "CMakeFiles\\Bloc_autogen.dir\\ParseCache.txt"
  )
endif()
